def removeUnusedImages() {
    echo "Removing unused Docker images..."
    sh "docker image prune -af"
}

def removeDanglingImages() {
    echo "Removing dangling Docker images..."
    sh "docker images -f 'dangling=true' -q | xargs -r docker rmi -f"
}

def removeStoppedContainers() {
    echo "Removing stopped Docker containers..."
    sh "docker container prune -f"
}

def removeUnusedVolumes() {
    echo "Removing unused Docker volumes..."
    sh "docker volume prune -f"
}

def removeAllUnusedResources() {
    echo "Removing all unused Docker resources (images, containers, volumes, networks)..."
    sh "docker system prune -af"
}
