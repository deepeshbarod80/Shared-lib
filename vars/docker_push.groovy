def call(String Project, String ImageTag, String dockerHubUser){
withCredentials([usernamePassword(
  credentialsId:"dockerHubCred", 
  usernameVariable:"dockerHubUser", 
  passwordVariable:"dockerHubPass"
)]){
      sh "echo "${dockerHubPass}" | docker login -u "$dockerHubUser" --password-stdin"
      sh "docker tag notes-app:latest ${dockerHubUser}/${Project}:${ImageTag}"
      sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
    }
}
