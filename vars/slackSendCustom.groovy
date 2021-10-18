#!/usr/bin/env groovy

def call() {

    def color = ""

    switch(currentBuild.currentResult) {
        case "SUCCESS":
            color = "good"
            break
        case "UNSTABLE":
            color = "warning"
            break
        default:
            color = "danger"
            break
    }

    slackSend(color: color, message: """
Job    : ${env.JOB_NAME} #${env.BUILD_NUMBER}
Status : ${currentBuild.currentResult}
URL    : ${env.BUILD_URL}
Params : ${params} 
""")

}