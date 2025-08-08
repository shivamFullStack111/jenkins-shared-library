def call(String DOCKER_CONTAINER_NAME,String DOCKER_IMAGE_NAME){
  def containerName = sh(
    script: "docker ps -a --filter name='${DOCKER_CONTAINER_NAME}' --format '{{.Names}}'",
    returnStdout: true
  ).trim()
  if (containerName) { 
    sh "echo 'Deleting existing docker container...'"
    sh "docker rm -f ${DOCKER_CONTAINER_NAME}"
  } else{
    echo "No existing container..."
  }
  sh "docker build -t ${DOCKER_IMAGE_NAME} ."
}
