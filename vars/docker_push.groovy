def call(string Project, string ImageTag, string dockerHubUser){
withCredentials([usernamePassword(
  credentialsId:"dockerHubCred", 
  usernameVariable:"dockerHubUser", 
  passwordVariable:"dockerHubPass")]){
      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
      sh "docker image tag notes-app:latest ${env.dockerHubUser}/${Project}:${ImageTag}"
      sh "docker push ${env.dockerHubUser}/${Project}:${ImageTag}"
    }
}
