FROM node:20 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
RUN npm install axios @mui/material @emotion/react @emotion/styled

# Stage 2: Create a lightweight Node.js server
FROM node:20-alpine
WORKDIR /app
COPY --from=build /app/build /app
COPY package*.json ./
RUN npm install -g serve
EXPOSE 3000
CMD ["serve", "-p", "3000", "-s", "."]
