package com.ebanks.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.ResponseBody;

import com.ebanks.springapp.model.Person;
import com.ebanks.springapp.service.PersonService;

/**
 * The Class UserController.
 */
@Controller
public class UserController {

    public PersonService personService;

    @Autowired(required=true)
    @Qualifier(value="personService")
    public void setPersonService(PersonService personService){
        this.personService = personService;
    }

    /**
     * List persons.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersonsOrderbyLastNameASC());
        return "person";
    }


    /**
     * List persons.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/personsASC", method = RequestMethod.GET)
    public String listPersonsByLastNameASC(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersonsOrderbyLastNameASC());
        return "person";
    }

    //For add and update person both
    /**
     * Adds the person.
     *
     * @param p the p
     * @return the string
     */
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){

        if(p.getId() == 0){
            //new person, add it
            this.personService.addPerson(p);
        }else{
            //existing person, call update
            this.personService.updatePerson(p);
        }

        return "redirect:/persons";

    }

    /**
     * Removes the person.
     *
     * @param id the id
     * @return the string
     */
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){

        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    /**
     * Edits the person.
     *
     * @param id the id
     * @param model the model
     * @return the string
     */
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		return "Hello world!";
	}

}