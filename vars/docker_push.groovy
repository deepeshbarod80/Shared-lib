def call(String Project, String ImageTag, String dockerHubUser){
withCredentials([usernamePassword(
  credentialsId:"dockerHubCred", 
  usernameVariable:"dockerHubUser", 
  passwordVariable:"dockerHubPass")]){
      sh "echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin"
      sh "docker image tag notes-app:latest ${env.dockerHubUser}/${Project}:${ImageTag}"
      sh "docker push ${env.dockerHubUser}/${Project}:${ImageTag}"
    }
}
