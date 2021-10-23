#!/usr/bin/env groovy

/**
 * GitLab 측 status 업데이트 코드 반복 해결
 * @param stageName
 * @param buildStatus
 */
def call(String buildStatus) {
  def status = ""
  switch (buildStatus.toUpperCase()) {
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
  updateGitlabCommitStatus(name: STAGE_NAME, state: status)
}