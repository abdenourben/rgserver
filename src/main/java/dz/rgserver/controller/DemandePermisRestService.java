package dz.rgserver.controller;

import java.io.IOException;

import java.util.List;
import dz.rgserver.dao.DemandePermisRepository;
import dz.rgserver.model.DemandePermis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class DemandePermisRestService {
	
	@Autowired
	private DemandePermisRepository demandePermisRepository;
	
	
	@RequestMapping(value="/demandePermis", method = RequestMethod.GET)
	public List<DemandePermis> getAllDemandePermis(){
	
		return demandePermisRepository.findAll();
	}
	
	
	
	@RequestMapping(value="/demandePermis/{id}", method = RequestMethod.GET)
	public DemandePermis getOneDemandePermis(@PathVariable long id ){
	
		return demandePermisRepository.findById(id).get();
	}
	
	
// sauvegarder une demande de permis envoyé par mail
	@RequestMapping(value="/demandePermis", method = RequestMethod.POST)
	public DemandePermis saveDemandePermis(@RequestBody DemandePermis demandePermis ){
		demandePermis.setEtat("Brouillon");
		return demandePermisRepository.save(demandePermis);
	}
	
	@RequestMapping(value="/demandePermis/{id}", method = RequestMethod.DELETE)
	public  boolean deleteDemandePermis(@PathVariable long id ){
	
		demandePermisRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/demandePermis/{id}", method = RequestMethod.PUT)
	public DemandePermis updateDemandePermis(@PathVariable long id ,@RequestBody DemandePermis demandePermis ){
	
		demandePermis.setId_demande(id);
		return demandePermisRepository.save(demandePermis);
	}
	
	@RequestMapping(value="/chercherDemandePermis", method = RequestMethod.GET)
	public Page<DemandePermis> chercherDemandePermis(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return demandePermisRepository.chercherDemandePermis("%"+mc+"%", new PageRequest(page, size));
	}
	/****Les trois fonctions du workflow:
     *autoriserDemandePermis, 
     *nePasAutoriserDemandePermis,
     *mettreEnAttenteDemandePermis
*****/
@RequestMapping(value="/autoriserDemandePermis/{id}", method = RequestMethod.POST)
public DemandePermis autoriserDemandePermis(@PathVariable("id") long id ){
 DemandePermis demandePermis= demandePermisRepository.findById(id).get();
 demandePermis.setEtat("autorisé");
 return demandePermisRepository.save(demandePermis);
}
	
	@RequestMapping(value="/nePasAutoriserDemandePermis/{id}", method = RequestMethod.POST)
	public DemandePermis nePasAutoriserDemandePermis(@PathVariable long id ){
		DemandePermis demandePermis= demandePermisRepository.findById(id).get();
		 demandePermis.setEtat("non autorisé");
		 return demandePermisRepository.save(demandePermis);
	}
	

	
	@RequestMapping(value="/mettreEnAttenteDemandePermis/{id}", method = RequestMethod.POST)
	public void mettreEnAttenteDemandePermis(@PathVariable long id ) {
		DemandePermis demandePermis= demandePermisRepository.findById(id).get();
		 demandePermis.setEtat("en attente");
	     demandePermisRepository.save(demandePermis);
	}
	
	
	//la fonction d'envoie par mail

	@RequestMapping(value="/envoyerMail/{id}", method = RequestMethod.POST)
	public void envoyerMaill(@PathVariable long id) {
		//adresseMail
		DemandePermis demandePermis= demandePermisRepository.findById(id).get();
		String etatPermis =demandePermis.getEtat();
		String etatAutorise= "autorisé";
		String etatNonAutorise="non autorisé";

		if(etatPermis.equals(etatAutorise)) {
		    String m=demandePermis.getAdresseMail();
		    String apikey = "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";
	        Email from = new Email("contact_APA@gmail.com");
	        String subject = "Autorisation- Demande- Permis";
	        Email to = new Email(m);
	        Content content = new Content("text/plain", " Vous avez accès à la ressource. ");
	        Mail mail = new Mail(from, subject, to, content);
	        SendGrid sg = new SendGrid(apikey);
	        Request request = new Request();
	        try {
	            request.setMethod(Method.POST);
	            request.setEndpoint("mail/send");
	            request.setBody(mail.build());
	            Response response = sg.api(request);
	            System.out.println(response.getStatusCode());
	            System.out.println(response.getBody());
	            System.out.println(response.getHeaders());
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	      
    }
	
	else {
		if(etatPermis.equals(etatNonAutorise)) {
			    String m=demandePermis.getAdresseMail();
			    String apikey = "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";
		        Email from = new Email("contact_APA@gmail.com");
		        String subject = "Non-Autorisation-Demande-Permis";
		        Email to = new Email(m);
		        Content content = new Content("text/plain", " Nous avons le regret de vous annoncé que Vous avez accès à la ressource. ");
		        Mail mail = new Mail(from, subject, to, content);
                SendGrid sg = new SendGrid(apikey);
		        Request request = new Request();
		        try {
		            request.setMethod(Method.POST);
		            request.setEndpoint("mail/send");
		            request.setBody(mail.build());
		            Response response = sg.api(request);
		            System.out.println(response.getStatusCode());
		            System.out.println(response.getBody());
		            System.out.println(response.getHeaders());
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        } 
		}	
		
	}
		
	}

	
	

}
