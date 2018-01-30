/* Requires the Docker Pipeline plugin */
node('docker') {
    checkout scm
    stage('Build') {
        docker.image('maven:3.3.3').inside {
            echo 'Building'
            sh 'mvn --version'
            sh 'mvn --build'
        }
    }
    /*stage('Deploy') {
        sh 'mvn deploy:deploy-file
        -Durl=http://172.17.0.3:8081/repository/maven-snapshots/t1.snapshot/
        -DrepositoryId=t1.snapshot
    }*/
}
