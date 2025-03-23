// Define function
def docker_build(String Project, String ImageTag, String DockerHubUser){
  sh "docker build -t ${DockerHubUser}/${Project}:${ImageTag} ."
}
