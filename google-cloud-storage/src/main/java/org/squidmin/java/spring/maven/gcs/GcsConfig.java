package org.squidmin.java.spring.maven.gcs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class GcsConfig {

    private final String projectId;
    private final String bucketName;
    private final String impersonationTarget;
    private final String accessToken;
    private final String gkmsKeyName;

    public GcsConfig(@Value("${gcp.project-id:#{systemEnvironment['PROJECT_ID']}}") String projectId,
                     @Value("${gcp.storage.bucket.name:#{systemEnvironment['GCS_BUCKET_NAME']}}") String bucketName,
                     @Value("${gcp.auth.impersonation-target:#{systemEnvironment['IMPERSONATION_TARGET']}}") String impersonationTarget,
                     @Value("${gcp.auth.access-token:#{systemEnvironment['OAUTH_ACCESS_TOKEN']}}") String accessToken,
                     @Value("${gcp.kms.key-name:#{systemEnvironment['GKMS_KEY_NAME']}}") String gkmsKeyName) {

        this.projectId = projectId;
        this.bucketName = bucketName;
        this.impersonationTarget = impersonationTarget;
        this.accessToken = accessToken;
        this.gkmsKeyName = gkmsKeyName;

    }

}
