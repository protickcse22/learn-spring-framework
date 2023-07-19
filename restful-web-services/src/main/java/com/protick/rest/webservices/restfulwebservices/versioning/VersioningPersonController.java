package com.protick.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfURI() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfURI() {
        return new PersonV2("Bob", "Charlie");
    }


    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfRequestParam() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfRequestParam() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfRequestHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfRequestHeader() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(path = "/person", produces = "application/dummy-v1+json")
    public PersonV1 getFirstVersionOfAcceptHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", produces = "application/dummy-v2+json")
    public PersonV2 getSecondVersionOfAcceptHeader() {
        return new PersonV2("Bob", "Charlie");
    }
}
