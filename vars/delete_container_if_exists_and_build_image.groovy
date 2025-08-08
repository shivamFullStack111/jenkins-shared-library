def call(String DOCKER_CONTAINER_NAME,String DOCKER_IMAGE_NAME){
  if ( docker ps -a --name ${DOCKER_CONTAINER_NAME} --format {{.Names}}==${DOCKER_CONTAINER_NAME}) { 
    echo "Deleting existing docker container..."
    docker rm -f ${DOCKER_CONTAINER_NAME}
  } else{
    echo "No existing container..."
  }
  docker build -t ${DOCKER_IMAGE_NAME} .
}
