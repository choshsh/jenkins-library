#!/usr/bin/env groovy

def call(String stageName, String buildStatus) {

    if(stageName == "" || buildStatus == "") {
        echo "parameter is invalid."
        return;
    }

    def status = ""

    switch(buildStatus.toUpperCase()) {
        case "SUCCESS":
            status = "success";
            break;
        case "PENDING":
            status = "pending";
            break;
        default:
            status = "falied";
            break;
    }

    updateGitlabCommitStatus(name: stageName, state: status)

}