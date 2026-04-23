#!/bin/bash
echo "🚀 Iniciando despliegue de infraestructura para SaberPlay..."

cd terraform

# Inicializar Terraform
terraform init

# Validar que el código es correcto
terraform validate

# Generar el plan de ejecución y aplicarlo
# Nota: Te pedirá la contraseña de la DB al ejecutar
terraform apply -auto-approve

echo "✅ ¡Infraestructura levantada! La Sagrada Familia ya tiene su base de datos y servidor en la nube."
