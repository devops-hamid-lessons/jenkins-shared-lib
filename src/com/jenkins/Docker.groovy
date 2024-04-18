#! /usr/bin/env groovy

package com.jenkins

class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName){
        script.sh "docker build -t $imageName ."
    }

    def loginDocker(String creditId){
        script.withCredentials([script.usernamePassword(credentialsId: creditId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh "echo ${script.env.PASS} | docker login -u ${script.env.USER} --password-stdin "
        }

    }

    def pushDockerImage(String imageName){
        script.sh "docker push $imageName"
    }

}
