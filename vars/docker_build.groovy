// Define function
def call(String Project, String ImageTag, String DockerHubUser){
  sh "docker build -t ${DockerHubUser}/${Project}:${ImageTag} ."
}
