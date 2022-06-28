resource "aws_launch_configuration" "web" {
  name_prefix = "web-"

  image_id = "ami-052efd3df9dad4825" 
  instance_type = "t2.micro"
  key_name = var.aws_envkey

  security_groups = [ aws_security_group.allow_http.id, aws_security_group.sg_22.id ]
  associate_public_ip_address = true

  user_data = <<-EOF
#!/bin/bash
apt-get update -y
apt-get upgrade -y
apt-get install apache2 -y
systemctl start apache2
systemctl enable — now apache2
  EOF

  lifecycle {
    create_before_destroy = true
  }
}

