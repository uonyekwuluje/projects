# Project Terraform Stack Operations
Export the following first
```
export AWS_ACCESS_KEY_ID="<your aws access key>"
export AWS_SECRET_ACCESS_KEY="<your aws secret key>"
export IP_ADDRESS="<your ip address>"
export DNS_NAME="<dns name>"
export ZONE_ID="<zone id>"
```

Create `.env.sh` file. This is excluded and never checked in
```
#!/bin/bash
cat <<EOF
{
  "IP_ADDRESS": "$IP_ADDRESS",
  "DNS_NAME": "$DNS_NAME",  
  "ZONE_ID": "$ZONE_ID"
}
```

Terraform Commands
```
terraform init
terraform validate
terraform plan 
terraform apply -auto-approve
terraform destroy -auto-approve
terraform state pull
```

## Connect to new node
Terraform apply will output the Public IP of the VM. You can SSH Directly
```
ssh -i <ssh key> admin@<ip address>
```
