# google-cloud-storage

## Run the application

```bash
cd google-cloud-storage
```

## Set environment variables

```bash
export PROJECT_ID=<your-project-id>
export GCS_BUCKET_NAME=<your-gcs-bucket-name>
export IMPERSONATION_TARGET=<your-service-account-email>
export OAUTH_ACCESS_TOKEN=$(gcloud auth print-access-token --impersonate-service-account=${IMPERSONATION_TARGET})
export GKMS_KEY_NAME=<your-gkms-key-name>
```

```bash
mvn spring-boot:run \
  -Dspring-boot.run.jvmArguments="\
-DPROJECT_ID=$PROJECT_ID \
-DGCS_BUCKET_NAME=$GCS_BUCKET_NAME \
-DIMPERSONATION_TARGET=$IMPERSONATION_TARGET \
-DOAUTH_ACCESS_TOKEN=$(gcloud auth print-access-token \
  --impersonate-service-account=${IMPERSONATION_TARGET}) \
-DGKMS_KEY_NAME=$GKMS_KEY_NAME
"
```

## Run tests

```bash
mvn clean test \
  -DskipTests \
  -DGCP_PROJECT_ID=${GCP_PROJECT_ID}
```

## Build image

```bash
docker build -t google-cloud-storage-ref .
```

## Run container

```bash
docker run -p 8080:8080 \
  -v "${USER_SVC_ACCOUNT_KEY_PATH}:/sa.json:ro" \
  -e GOOGLE_APPLICATION_CREDENTIALS=/sa.json \
  -e PROJECT_ID \
  -e GCS_BUCKET_NAME \
  -e IMPERSONATION_TARGET \
  -e OAUTH_ACCESS_TOKEN \
  -e GKMS_KEY_NAME \
  google-cloud-storage-ref
```
