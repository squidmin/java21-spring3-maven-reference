# google-cloud-storage

## Run the application

```bash
cd google-cloud-storage
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

## Running tests

```bash
./gradlew cleanTest test \
  --no-build-cache \
  -DGCP_PROJECT_ID=${GCP_PROJECT_ID}
```

**Example**:

```bash
./gradlew cleanTest test \
  --no-build-cache \
  -DGCP_PROJECT_ID=${GCP_PROJECT_ID}
```

#### Maven equivalent

```bash
mvn clean test \
  -DskipTests \
  -DGCP_PROJECT_ID=${GCP_PROJECT_ID}
```
