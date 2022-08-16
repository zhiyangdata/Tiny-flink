namespace java org.team3090.simple.server
service WorkerService{
    string startJob(1:list<string> jsonConfig)
}