FROM node:20 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Create a lightweight Node.js server
FROM node:20-alpine
WORKDIR /app
COPY --from=build /app/build /app
COPY package*.json ./
RUN npm install -g serve
EXPOSE 3000
CMD ["serve", "-p", "3000", "-s", "."]
