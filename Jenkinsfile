pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {
        stage('Source') {
            steps {
                git branch: 'main', url: 'https://github.com/ramanujds/spring-boot'
            }
        }

        stage('Test'){
            steps{
                sh "mvn test"
            }
        }

        stage('Build'){
            steps{
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }


            post {

                success {

                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Build Docker Image') {
                    steps{
                        sh "docker build --platform linux/amd64 -t spring-boot:latest ."
                    }
                 }
        stage('Push Docker Image') {
            steps {
              withCredentials([string(credentialsId: 'dockerhub_pdw', variable: 'dockerhub_pdw')]){
                        sh 'docker login -u ram1uj -p ${dockerhub_pdw}'
                        sh 'docker tag spring-boot:latest ram1uj/spring-boot:latest'
                        sh 'docker push ram1uj/spring-boot:latest'
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                  sh 'gcloud container clusters get-credentials app-cluster --region asia-south1 --project upgradlabs-1746877449603h 'kubectl delete deployment spring-boot-app || true'
                   sh 'kubectl get svc'
//                 sh 'kubectl delete deployment spring-boot-app || true'
//                 sh 'kubectl apply -f deployment.yml'
//                 sh 'kubectl apply -f service.yml'
//                 sh 'kubectl rollout status deployment/spring-boot-app'
            }
           }

       }

 }

