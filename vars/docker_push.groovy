def call(String Project, String ImageTag, String dockerHubUser){
withCredentials([usernamePassword(
  credentialsId:"dockerHubCred", 
  usernameVariable:"dockerHubUser", 
  passwordVariable:"dockerHubPass"
)]){
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass} --password-stdin"
      sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
    }
}
