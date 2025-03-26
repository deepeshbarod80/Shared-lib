def call(String Project, String ImageTag, String dockerHubUser){
withCredentials([usernamePassword(
  credentialsId:"dockerHubCred", 
  usernameVariable:"dockerHubUser", 
  passwordVariable:"dockerHubPass"
)]){
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
      sh "docker push ${env.dockerHubUser}/${Project}:${ImageTag}"
    }
}
