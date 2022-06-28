variable "AWS_REGION" {    
    default = "us-east-1"
}

variable "aws_ec2_ami" {
    default = "ami-09a41e26df464c548"
}

variable "aws_instance_type" {
    default = "t2.micro"
}

variable "aws_environment" {
    default = "web_project"
}

variable "aws_envkey" {
    default = "ucheaws-dev-key"
}
