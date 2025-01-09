# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6f63d3ce5fdb6ff9577d66fa59838f30"

ROS_BRANCH ?= "branch=put-humble"
SRC_URI = "git://github.com/PX4/px4_msgs.git;protocol=https;branch=release/1.15"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "18cbccedb6c304b180bca8e81a4a601758fc9de9"

S = "${WORKDIR}/git"
inherit ros_distro_humble
inherit ros_superflore_generated
inherit ros_ament_cmake

ROS_BUILD_DEPENDS = "\
    rclcpp \
    builtin-interfaces \
    rosidl-default-generators \
    ros-environment \
    rosidl-adapter \
    ament-package \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-ros \
    rosidl-default-generators-native \
    ament-package-native \
"
ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    rosidl-default-runtime \
"
ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    builtin-interfaces \
    rosidl-default-runtime \
"
DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

