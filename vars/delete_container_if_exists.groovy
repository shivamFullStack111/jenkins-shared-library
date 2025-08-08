def call(String DOCKER_CONTAINER_NAME){
  if [ "$(docker ps -a --name ${DOCKER_CONTAINER_NAME} --format {{.Names}})"="${DOCKER_CONTAINER_NAME}" ]; then 
    echo "Deleting existing docker container..."
    docker rm -f ${DOCKER_CONTAINER_NAME}
  else
    echo "No existing container..."
  fi
}
