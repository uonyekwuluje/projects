resource "aws_route53_record" "portfolio_server" {
  zone_id = data.external.env.result["ZONE_ID"]
  name    = data.external.env.result["DNS_NAME"]
  type    = "A"
  ttl     = "300"
  records = [aws_instance.portfolio_instance.public_ip]
}
