resource "aws_security_group" "sg_22" {
  name = "sg_22"

  ingress {
      from_port   = 22
      to_port     = 22
      protocol    = "tcp"
      cidr_blocks = ["${data.external.env.result["IP_ADDRESS"]}/32"]
  }
  ingress {
      from_port   = 80
      to_port     = 80
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
  } 
  ingress {
      from_port   = 443
      to_port     = 443
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
  } 

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }  

  tags = {
    Environment = var.aws_environment
  }
}

resource "aws_instance" "portfolio_instance" {
  ami                    = var.aws_ec2_ami
  instance_type          = var.aws_instance_type
  key_name               = var.aws_envkey
  security_groups        = [aws_security_group.sg_22.name]

  tags = {
    Environment = var.aws_environment
    Name = "portfolio-server"
 }
}


output "server_ip" {
  value = aws_instance.portfolio_instance.public_dns
}
