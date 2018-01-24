package heroes.testPackage;


import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import heroes.Hero;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;

        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
import heroes.testPackage.HeroRepository;
@CrossOrigin

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
/*for  avoid error Access-Control-Allow-Origin in angular
Cross-origin resource sharing (CORS)

*/
@Configuration
@RestController
@RequestMapping("/hero")
public class HeroController{
    /***************************************************************/
// @Autowired
// private AuthenticationManager authenticationManager;
    @Autowired
    private HeroRepository heroRepo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Hero>> getStudents() {
        return new ResponseEntity<>(heroRepo.findAll(), HttpStatus.OK);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hero getStudent(@PathVariable long id) {
        return  heroRepo.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Collection<Hero>> deleteStudent(@PathVariable long id) {
        Hero student = heroRepo.findOne(id);
        heroRepo.delete(id);

        return new ResponseEntity<>(heroRepo.findAll(), HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Hero student) {
        return new ResponseEntity<>(heroRepo.save(student), HttpStatus.CREATED);
    }
   /* @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
       // Student updatestudent = studentRepo.findOne(student.getId());

        studentRepo.findOne(student.getId()).setAge(student.getAge());
        studentRepo.findOne(student.getId()).setName(student.getName());

        return new ResponseEntity<>(studentRepo.findOne(student.getId()), HttpStatus.OK);
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?>  updateStudent(@PathVariable("id") long id,
                                                          @RequestBody @Valid Hero student){
      /*  Student updatestudent = studentRepo.findOne(id);
        updatestudent.setAge(student.getAge());
        updatestudent.setName(student.getName());

        return new ResponseEntity<>(updatestudent , HttpStatus.OK);*/

        return new ResponseEntity<>(heroRepo.save(student), HttpStatus.OK);
    }


}
