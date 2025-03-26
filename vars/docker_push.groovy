def call(String Project, String ImageTag, String dockerHubUser){
withCredentials([usernamePassword(
  credentialsId:"dockerHubCred", 
  usernameVariable:"dockerHubUser", 
  passwordVariable:"dockerHubPass"
)]){
      sh '''
      echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
      '''
      sh "docker tag ${Project}:${ImageTag} $dockerHubUser/${Project}:${ImageTag}"
      sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
    }
}
