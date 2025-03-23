def call(String Project, String ImageTag){
  withCredentials([usernamePassword(
                    credentialsId:"dockerHubCred",
                    passwordVariable: "dockerHubPass",
                    usernameVariable: "dockerHubUser"
                )]){
                
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker image tag ${imageName} ${env.dockerHubUser}/${imageName}"
                sh "docker push ${env.dockerHubUser}/${project}:${ImageTag}"
            
                }  
}
