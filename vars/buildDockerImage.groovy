#! /usr/bin/env groovy

import com.jenkins.Docker
// this is a test code
def call(String imageName){
    return new Docker(this).buildDockerImage(imageName)
}