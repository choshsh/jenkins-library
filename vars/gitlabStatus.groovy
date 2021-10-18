#!/usr/bin/env groovy

def call(String stageName, String buildStatus) {

    def status = ""

    switch(buildStatus.toUpperCase()) {
        case "SUCCESS":
            status = "success"
            break
        case "PENDING":
            status = "pending"
            break
        default:
            status = "falied"
            break
    }

    updateGitlabCommitStatus(name: stageName, state: status)

}