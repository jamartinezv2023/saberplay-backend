# Configuración para desplegar en AWS (Ejemplo)
resource "aws_db_instance" "saberplay_db" {
  allocated_storage    = 20
  db_name              = "saberplay"
  engine               = "postgres"
  engine_version       = "15"
  instance_class       = "db.t3.micro"
  username             = "admin"
  password             = "seguridad_familia_2026"
  skip_final_snapshot  = true
}

resource "aws_elastic_beanstalk_application" "saberplay_app" {
  name        = "saberplay-backend"
  description = "Backend Multitenant para SaberPlay"
}
