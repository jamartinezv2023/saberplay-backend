resource "aws_apprunner_service" "saberplay_backend" {
  service_name = "saberplay-api"

  source_configuration {
    image_repository {
      image_identifier      = "public.ecr.aws/saberplay/backend:latest"
      image_repository_type = "ECR_PUBLIC"
    }
  }
}
