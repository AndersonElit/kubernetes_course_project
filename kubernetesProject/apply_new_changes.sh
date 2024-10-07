set -e

echo "clean and build project..."
gradle clean && gradle build

IMAGE_NAME="andersonelit/kubernetesproject:latest"

echo "Verify if the image exist..."
if docker image inspect "$IMAGE_NAME" > /dev/null 2>&1; then
    echo "Image $IMAGE_NAME exists."
    docker rmi "$IMAGE_NAME" || true
fi

echo "Building image $IMAGE_NAME..."
docker build -t "$IMAGE_NAME" .

echo "Pushing image $IMAGE_NAME..."
docker push "$IMAGE_NAME"

if minikube status | grep -q "host: Stopped"; then
    echo "Starting Minikube..."
    minikube start
fi

echo "Deploy Kubernetes deployment file..."
kubectl apply -f deployment.yaml

echo "Redeployment completed."

