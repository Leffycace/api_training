package fr.esiea.ex4A.api;

import fr.esiea.ex4A.entity.Match;
import fr.esiea.ex4A.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiController {

    @PostMapping("/api/inscription")
    public ResponseEntity<?> addUser(@RequestBody Map<String, String> request) throws IOException {
        String userName = request.get("userName");
        String userCountry = request.get("userCountry");

        User user = new User(request.get("userEmail"), userName, request.get("userTweeter"), userCountry, request.get("userSex"), request.get("userSexPref"));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/api/matches")
    public ResponseEntity<?> getMatches(@RequestParam("userName") String userName, @RequestParam("userCountry") String userCountry){

        List<Match>matchList=new ArrayList<>();
        matchList.add(new Match("Leo", "api"));
        matchList.add(new Match("Hugo", "api2"));

        return new ResponseEntity<>(matchList,HttpStatus.OK);
    }

}


