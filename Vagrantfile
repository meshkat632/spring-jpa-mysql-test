require 'erb'
require 'ostruct'
 
Vagrant.configure("2") do |config|

  config.vm.provider 'virtualbox' do |v|
    v.memory = 1536
    v.cpus = 1
  end

  devvm_disk = 'devvm.vdi'

  config.vm.define :devvm do |box|
      box.vm.box = "ubuntu/trusty64"
      box.vm.network :private_network, ip: "192.168.1.48"
      box.vm.network "forwarded_port", guest: 80,   host: 80,   auto_correct: false
      box.vm.network "forwarded_port", guest: 8080, host: 8080, auto_correct: false
      box.vm.network "forwarded_port", guest: 8081, host: 8081, auto_correct: false
      box.vm.network "forwarded_port", guest: 3000, host: 3000, auto_correct: false
      box.vm.network "forwarded_port", guest: 9200, host: 9200, auto_correct: false    
      box.vm.network "forwarded_port", guest: 5601, host: 5601, auto_correct: false      
      box.vm.network "forwarded_port", guest: 3306, host: 3306, auto_correct: false
      box.vm.network "forwarded_port", guest: 5432, host: 5432, auto_correct: false                
      box.vm.host_name = "gs-jpa-test"
      
      box.vm.synced_folder "vagrant-scripts/scripts/", "/tmp/vagrant-scripts/scripts/"            

      config.vm.provider 'virtualbox' do |v|
        v.memory = 2048
        v.cpus = 1
      end
      config.ssh.username = "vagrant"
      config.ssh.password = "vagrant"
      config.ssh.insert_key = true
      
      config.vm.provision :shell, :path => "vagrant-scripts/scripts/provisioner-update-ubuntu.sh"
      config.vm.provision :shell, :path => "vagrant-scripts/scripts/install-docker.sh"
      config.vm.provision :shell, :path => "vagrant-scripts/scripts/install-docker-compose.sh"
      config.vm.provision :shell, :path => "vagrant-scripts/scripts/init-docker.sh"      
  end
end