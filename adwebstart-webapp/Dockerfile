FROM node:20-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
RUN npm install react-scripts@latest
RUN npm install @mui/material @emotion/react @emotion/styled
RUN npm install axios
# RUN npm install -g serve
COPY . .
RUN npm run build
EXPOSE 3000
#CMD ["serve", "-p", "3000", "-s", "."]
CMD ["npm", "start"]

