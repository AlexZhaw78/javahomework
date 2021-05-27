package ru.java.zhaw;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")
public class TutorialControllerSimple {
	@Autowired
    TutorialRepository tutorialRepository;
//=========================================================================================
	  @GetMapping("/tutorials")
	  List<Tutorial> all() {
	    return tutorialRepository.findAll();
	  }
//=========================================================================================
	  @PostMapping("/tutorials")
	  Tutorial newTutorial(@RequestBody Tutorial newTutorial) {
	    return tutorialRepository.save(newTutorial);
	  }	  
//=========================================================================================
	  @GetMapping("/tutorials/{id}")
	  Tutorial one(@PathVariable Long id) {
	    
	    return tutorialRepository.findById(id)
	      .orElseThrow(() -> new TutorialNotFoundException(id));
	  }	  
//=========================================================================================	
	  @PutMapping("/tutorials/{id}")
	  Tutorial replaceTutorial(@RequestBody Tutorial newTutorial, @PathVariable Long id) {

		    Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

		    if (tutorialData.isPresent()) {
		      Tutorial _tutorial = tutorialData.get();
		      _tutorial.setTitle(newTutorial.getTitle());
		      _tutorial.setDescription(newTutorial.getDescription());
		      _tutorial.setPublished(newTutorial.isPublished());
		      return tutorialRepository.save(_tutorial);
		    } else {
		      return null;
		    }		  

    
		    
	    /*return tutorialRepository.findById(id)
	      .map(tutorial -> {
	    	  tutorial.setTitle(newTutorial.getTitle());
	    	  tutorial.setDescription(newTutorial.getDescription());
	    	  tutorial.setPublished(newTutorial.getPublished());
	        return tutorialRepository.save(employee);}
    		  )
	      .orElseGet(() -> {
	    	  newTutorial.setId(id);
	        return tutorialRepository.save(newTutorial);
	      }); */
	  }
//=========================================================================================
	  @DeleteMapping("/tutorials/{id}")
	  void deleteTutorial(@PathVariable Long id) {
		  tutorialRepository.deleteById(id);
	  }	  
//=========================================================================================	  
}
