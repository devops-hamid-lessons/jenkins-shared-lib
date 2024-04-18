#! /usr/bin/env groovy

import com.jenkins.Docker

def call(String creditId){
    return new Docker(this).loginDocker(creditId)
}