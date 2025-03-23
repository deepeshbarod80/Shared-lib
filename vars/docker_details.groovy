pipeline{
    agent {
        label "jenkins-slave"
    }
    
    stages{
        stage("Clone"){
            steps{
                echo "This is Clonning the code"
                git url: "https://github.com/deepeshbarod80/Django-CICD.git", branch: "main"
                echo "Code Clonning successful"
            }
        }
        stage("Build"){
            steps{
                echo "Building the code"
                sh "docker build -t notes-app:latest ."
                echo "Building code is successful"
            }
        }
        stage("Push"){
            steps{
                echo "This is building the Image to DockerHub"
                withCredentials([usernamePassword(
                    credentialsId:"dockerHubCred", 
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker image tag notes-app:latest ${env.dockerHubUser}/notes-app:latest"
                sh "docker push ${env.dockerHubUser}/notes-app:latest"
                echo "Code pushed Successfully"
                }
            }
        }
        stage("Deploy"){
            steps{
                echo "This is building the Code in local"
                sh "docker-compose down -v"
                sh "docker-compose up -d"
                echo "Code is Deployed Successfully using Docker compose"
            }
        }
    }
}
