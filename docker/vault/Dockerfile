FROM vault:1.13.3
WORKDIR /
EXPOSE 8200
COPY ./config/vault.json ./config/vault.json
ENTRYPOINT vault server -config=./config/vault.json
