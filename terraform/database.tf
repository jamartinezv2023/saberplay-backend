resource "aws_db_instance" "saberplay_production" {
  identifier           = "saberplay-prod-db"
  allocated_storage    = 20
  storage_type         = "gp2"
  engine               = "postgres"
  engine_version       = "15.4"
  instance_class       = "db.t3.micro"
  db_name              = "saberplay"
  username             = "saber_admin"
  password             = var.db_password
  publicly_accessible  = false
  skip_final_snapshot  = true
}
