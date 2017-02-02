

function getVelocityInfo(velocityInfo) {
    //v = v0 + at
    var finalVelocity = velocityInfo.initialVelocity + (velocityInfo.acceleration * velocityInfo.time);
    velocityInfo.finalVelocityInfo = finalVelocity;
    return velocityInfo;

}

function getKineticEnergyInfo(ke,velocityInfo,mass) {
  //K = (1/2) mv2
  ke.mass = mass;
  ke.velocity = velocityInfo.finalVelocityInfo;
  ke.kineticEnergy = (ke.mass * ke.velocity + ke.velocity)/2;
  return ke;
}

function getMomentum(momentum,mass,velocityInfo) {
    //p = mv
    momentum.mass = mass;
    momentum.velocity = velocityInfo.finalVelocityInfo;
    momentum.p = momentum.mass * momentum.velocity;
    return momentum;
}

function getWeight(weight,mass) {
    //W = mg
    weight.mass = mass;
    weight.gravity = 9.807; //Constant
    weight.weight = weight.mass * weight.gravity;
    return weight;
}