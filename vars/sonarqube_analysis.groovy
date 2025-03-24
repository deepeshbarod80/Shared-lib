def call(String SonarQubeAPI, String Project, String ProjectKey){
  withSonarQubeEnv("${SonarQubeAPI}"){
      sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.project=${Project} -Dsonar.projectKey=${ProjectKey} -X"
  }
}
