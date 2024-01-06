terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "2.23.1"
    }
  }
}

provider "docker" {
  host = "unix:///var/run/docker.sock" # Docker on ubuntu connection
}


resource "docker_container" "selenoid" {
  name  = "selenoid"
  image = "aerokube/selenoid:latest-release"

  networks_advanced {
    name = "selenoid"
  }

  volumes {
    host_path      = "/../resources" #path to your config folder containing browsers.json
    container_path = "/etc/selenoid"
  }

  volumes {
    host_path      = "/var/run/docker.sock"
    container_path = "/var/run/docker.sock"
  }

  volumes {
    host_path      = "/../resources/video" #path to your videos folder
    container_path = "/opt/selenoid/video"
  }

  env = ["OVERRIDE_VIDEO_OUTPUT_DIR=../resources/video"] #path to your videos folder

  command = ["-conf", "/etc/selenoid/browsers.json", "-video-output-dir", "/opt/selenoid/video", "-log-output-dir", "/opt/selenoid/logs", "-container-network", "selenoid"]

  ports {
    external = 4444
    internal = 4444
  }
}

resource "docker_image" "selenoid-ui" {
  name         = "aerokube/selenoid-ui:latest"
}

resource "docker_container" "selenoid-ui" {
  image = docker_image.selenoid-ui.latest
  name  = "selenoid-ui-terraform"
networks_advanced {
    name = "selenoid"
  }
  ports {
    internal = 8080
    external = 8080
  }
 command = ["--selenoid-uri", "http://selenoid:4444"]
  
}

resource "docker_image" "selenoid-video" {
  name = "selenoid/video-recorder:latest"
}
resource "docker_image" "selenoid-chrome" {
  name = "selenoid/chrome:110.0"
}

resource "docker_image" "selenoid-firefox" {
  name = "selenoid/firefox:110.0"
}

