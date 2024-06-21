FROM node:latest

WORKDIR /app

COPY package.json ./

RUN npm config set registry "https://registry.npmjs.com/"
RUN npm install -g @angular/cli
RUN npm install

COPY . .

EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0", "--port", "4200"]
